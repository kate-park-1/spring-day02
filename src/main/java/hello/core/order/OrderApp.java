package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Member member = new Member(2L,"MemberB", Grade.VIP);
        memberService.join(member);
        Member findMember = memberService.findMember(2L);
        Order order = orderService.createOrder(2L, "itemA", 20000);
        System.out.println(findMember.getName() + ":" + findMember.getGrade());
        System.out.println("주문금액 : " + order.getItemPrice() + ", 할인금액 : " + order.getDiscountPrice()+
                ", 할인적용금액 : " + order.calculatePrice());
    }
}
