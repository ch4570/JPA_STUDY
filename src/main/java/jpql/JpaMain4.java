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

                Member member1 = new Member();
                member1.setUserName("관리자1");
                member1.setMemberType(MemberType.USER);
                member1.setAge(10);

                Member member2 = new Member();
                member2.setUserName("관리자2");
                member2.setMemberType(MemberType.USER);
                member2.setAge(10);


                member2.setTeam(team);

                em.persist(member1);
                em.persist(member2);



            em.flush();
            em.clear();

//            String query = "select " +
//                                 "case when m.age <= 10 then '학생요금' "
//                                +      "when m.age >= 60 then '경로요금' "
//                                +      "else '일반요금'" +
//                                        "end " +
//                            "from Member m";

            String query = "select function('group_concat', m.userName) From Member m";

            List<String> result = em.createQuery(query,String.class)
                             .getResultList();

            for(String s : result) {
                System.out.println("s = " + s);
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
