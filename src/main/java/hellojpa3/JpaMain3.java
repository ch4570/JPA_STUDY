//package hellojpa3;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
//
//public class JpaMain3 {
//    public static void main(String[] args) {
//
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
//
//        EntityManager em = emf.createEntityManager();
//
//        EntityTransaction tx = em.getTransaction();
//        // EntityManager는 데이터 변경시 트랜잭션을 시작해야 한다.
//
//        tx.begin();  // [트랜잭션] 시작
//
//        try{
//
//            Movie movie = new Movie();
//            movie.setDirector("aaaa");
//            movie.setActor("bbbb");
//            movie.setName("바람과 함께 사라지다");
//            movie.setPrice(10000);
//
//            em.persist(movie);
//
//            em.flush();
//            em.clear();
//
//            Item item = em.find(Item.class, movie.getId());
//            System.out.println("findMovie = " + item.toString());
//
//            tx.commit();
//        }catch(Exception e){
//            tx.rollback();
//        }finally {
//            em.close();
//        }
//        emf.close();
//    }
//}
