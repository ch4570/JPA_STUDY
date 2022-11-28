//package hellojpa4;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
//import java.util.List;
//import java.util.Set;
//
//public class JpaMain4 {
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
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setHomeAddress(new Address("homeCity", "street", "10000"));
//
//            member.getFavoriteFoods().add("치킨");
//            member.getFavoriteFoods().add("족발");
//            member.getFavoriteFoods().add("피자");
//
//            member.getAddressHistory().add(new AddressEntity("old1", "street", "10000"));
//            member.getAddressHistory().add(new AddressEntity("old2", "street", "10000"));
//
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
//            System.out.println("===================== START ===================");
//            Member findMember = em.find(Member.class, member.getId());
//
////            List<Address> addressHistory = findMember.getAddressHistory();
////            for(Address address : addressHistory) {
////                System.out.println("address = " + address.getCity());
////            }
////
////            Set<String> favoriteFoods = findMember.getFavoriteFoods();
////            for(String favoriteFood : favoriteFoods){
////                System.out.println("favoriteFood = " + favoriteFood);
////            }
//
//            // homeCity -> newCity
//            Address a = findMember.getHomeAddress();
////            findMember.setHomeAddress(new AddressEntity("newCity", a.getStreet(), a.getZipcode()));
//
//            // 치킨 -> 한식
//            findMember.getFavoriteFoods().remove("치킨");
//            findMember.getFavoriteFoods().add("한식");
//
////            findMember.getAddressHistory().remove(new AddressEntity("old1", "street", "10000"));
////            findMember.getAddressHistory().add(new AddressEntity("newCity1", "street", "10000"));
//
//            tx.commit();
//        }catch(Exception e){
//            tx.rollback();
//            e.printStackTrace();
//        }finally {
//            em.close();
//        }
//        emf.close();
//    }
//}
