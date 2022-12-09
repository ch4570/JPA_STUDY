package jpql;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

public class JpaMain4 {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        // EntityManager는 데이터 변경시 트랜잭션을 시작해야 한다.

        tx.begin();  // [트랜잭션] 시작

        try{

            Team teamA = new Team();
            teamA.setName("TeamA");
            em.persist(teamA);

            Team teamB = new Team();
            teamB.setName("TeamB");
            em.persist(teamB);

            Member member1 = new Member();
            member1.setUserName("회원1");
            member1.setTeam(teamA);
            em.persist(member1);

            Member member2 = new Member();
            member2.setUserName("회원2");
            member2.setTeam(teamA);
            em.persist(member2);

            Member member3 = new Member();
            member3.setUserName("회원3");
            member3.setTeam(teamB);
            em.persist(member3);

            em.flush();
            em.clear();

//            String query = "select " +
//                                 "case when m.age <= 10 then '학생요금' "
//                                +      "when m.age >= 60 then '경로요금' "
//                                +      "else '일반요금'" +
//                                        "end " +
//                            "from Member m";

            String query = "select t From Team t join fetch t.members";

            List<Team> result = em.createQuery(query, Team.class)
                             .getResultList();

            for (Team team : result) {
                System.out.println("team = " + team.getName() + " | members = " + team.getMembers().size());
                    for (Member member : team.getMembers()) {
                        System.out.println("-> member = "  +member);
                    }
            }

            // 회원1, 팀A(SQL)
            // 회원2, 팀A(1차 캐시)
            // 회원3, 팀B(SQL)

            // 회원 100명 -> N + 1

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
