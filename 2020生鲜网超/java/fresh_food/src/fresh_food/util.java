package fresh_food;

import example.ExampleCustomerManger;
import example.ExampleCustomerProductManger;
import example.ExampleDiscountManger;
import example.ExampleUserManger;
import example.ExampleUserProductManger;
import itf.ICustomerManger;
import itf.ICustomerProductManger;
import itf.IDiscountManger;
import itf.IUserManger;
import itf.IUserProductManger;

//import cn.edu.zucc.personplan.comtrol.example.ExamplePlanManager;
//import cn.edu.zucc.personplan.comtrol.example.ExampleStepManager;
//import cn.edu.zucc.personplan.comtrol.example.ExampleUserManager;
//import cn.edu.zucc.personplan.itf.IPlanManager;
//import cn.edu.zucc.personplan.itf.IStepManager;
//import cn.edu.zucc.personplan.itf.IUserManager;

public class util {
//	public static IPlanManager planManager=new ExamplePlanManager();//需要换成自行设计的实现类
//	public static IStepManager stepManager=new ExampleStepManager();//需要换成自行设计的实现类
//	public static IUserManager userManager=new ExampleUserManager();//需要换成自行设计的实现类
	public static IUserManger userManger = new ExampleUserManger();
	public static ICustomerManger customerManger = new ExampleCustomerManger();
	public static IUserProductManger userProductManger = new ExampleUserProductManger();
	public static IDiscountManger discountManger = new ExampleDiscountManger();
	public static ICustomerProductManger customerProductManger = new ExampleCustomerProductManger();
}
