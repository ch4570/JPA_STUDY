//package hellojpa2;
//
//import hellojpa2.MemberProduct;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//public class Product {
//
//    @Id @GeneratedValue
//    private Long id;
//
//    private String name;
//
////    @ManyToMany(mappedBy = "products")
//    @OneToMany(mappedBy = "product")
//    private List<MemberProduct> memberProducts = new ArrayList<>();
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//}
