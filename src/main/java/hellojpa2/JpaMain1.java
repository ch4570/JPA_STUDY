//package hellojpa;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
//import java.util.List;
//
//public class JpaMain1 {
//    public static void main(String[] args) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
//
//        EntityManager em = emf.createEntityManager();
//
//        EntityTransaction tx = em.getTransaction();
//        // EntityManager는 데이터 변경시 트랜잭션을 시작해야 한다.
//
//        tx.begin();  // [트랜잭션] 시작
//
//        try {
//            // 저장
//
//
//            Member2 member = new Member2();
//            member.setUsername("member1");
//            em.persist(member);
//
//
//            Team team = new Team();
//            team.setName("TeamA");
////          역방향(주인이 아닌 방향)만 연관관계 설정
//            team.getMembers().add(member);
//            member.setTeam(team); //**
//            em.persist(team);
//
////            team.addMember(member);
//
////          team.getMembers().add(member); //**
//
////          em.flush();
////          em.clear();
//
//            Team findTeam =  em.find(Team.class, team.getId()); // 1차 캐시에 존재
//            List<Member2> members = findTeam.getMembers();
//
//            System.out.println("====================================");
//          System.out.println("members = " + findTeam);
//
//            for(Member2 m : members){
//                System.out.println("m = " + m.getUsername());
//            }
//            System.out.println("====================================");
//
//
////            Member findMember = em.find(Member.class, member.getId());
////
////            List<Member> members =  findMember.getTeam().getMembers();
////
//
//
//            tx.commit();
//            } catch (Exception e) {
//                tx.rollback();
//            }finally{
//                em.close();
//            }
//                emf.close();
//    }
//}
