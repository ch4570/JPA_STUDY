//package hellojpa2;
//
//import hellojpa.Member2;
//
//import javax.persistence.*;
//import java.time.LocalDateTime;
//
//@Entity
//public class MemberProduct {
//
//    @Id @GeneratedValue
//    private Long id;
//
//    @ManyToOne
//    @JoinColumn(name = "MEMBER_ID")
//    private Member2 member2;
//
//    @ManyToOne
//    @JoinColumn(name = "PRODUCT_ID")
//    private Product product;
//
//    private int price;
//    private int count;
//
//    private LocalDateTime orderDateTime;
//}
