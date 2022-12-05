package jpql;

import javax.persistence.*;
import java.util.List;

public class JpaMain4 {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        // EntityManager는 데이터 변경시 트랜잭션을 시작해야 한다.

        tx.begin();  // [트랜잭션] 시작

        try{

                Team team = new Team();
                team.setName("TeamA");
                em.persist(team);

                Member member = new Member();
                member.setUserName("TeamA");
                member.setAge(10);

                member.setTeam(team);

                em.persist(member);



            em.flush();
            em.clear();

            List<Member> result =  em.createQuery("select m from Member m left join Team t on m.userName = t.name", Member.class)
                    .getResultList();

            System.out.println("result.size = " + result.size());
            for(Member member1  : result) {
                System.out.println("member1 = " + member1);
            }

            tx.commit();
        }catch(Exception e){
            tx.rollback();
            e.printStackTrace();
        }finally {
            em.close();
        }
        emf.close();
    }
}
