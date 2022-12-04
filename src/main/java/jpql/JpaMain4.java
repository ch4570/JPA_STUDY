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

            Member member = new Member();
            member.setUserName("member1");
            member.setAge(10);
            em.persist(member);

            Member result = em.createQuery("select m from Member m where m.userName = ?1", Member.class)
                    .setParameter(1, "member1")
                    .getSingleResult();

            System.out.println("result = " + result.getUserName());


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
