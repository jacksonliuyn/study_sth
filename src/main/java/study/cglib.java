package study;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * Created by qcl on 2018/11/29
 * desc:要被代理的类
 */
 class Base {
    public void add(){
        System.out.println("目标类的add方法");
    }
}


/**
 * Created by qcl on 2018/11/29
 * desc:这里加入切面逻辑
 */
 class CglibProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy)
            throws Throwable {
        System.out.println("before-------切面加入逻辑");
        methodProxy.invokeSuper(object, args);
        System.out.println("after-------切面加入逻辑");
        return null;
    }
}
/**
 * Created by qcl on 2018/11/29
 * desc:测试类
 */
 class CglibTest {
    public static void main(String[] args) {
        CglibProxy proxy = new CglibProxy();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Base.class);
        //回调方法的参数为代理类对象CglibProxy,最后增强目标类调用的是代理类对象CglibProxy中的intercept方法
        enhancer.setCallback(proxy);
        //此刻，base不是单车的目标类，而是增强过的目标类
        Base base = (Base) enhancer.create();
        base.add();

//        Class<? extends Base> baseClass = base.getClass();
//        //查看增强过的类的父类是不是未增强的Base类
//        System.out.println("增强过的类的父类："+baseClass.getSuperclass().getName());
//        System.out.println("============打印增强过的类的所有方法==============");
//        FanSheUtils.printMethods(baseClass);
//
//
//        //没有被增强过的base类
//        Base base2 = new Base();
//        System.out.println("未增强过的类的父类："+base2.getClass().getSuperclass().getName());
//        System.out.println("=============打印增未强过的目标类的方法===============");
//        FanSheUtils.printMethods(base2.getClass());//打印没有增强过的类的所有方法

    }
}
class FanSheUtils {

    //打印该类的所有方法
    public static void printMethods(Class cl) {
        System.out.println();
        //获得包含该类所有其他方法的数组
        Method[] methods = cl.getDeclaredMethods();
        //遍历数组
        for (Method method : methods) {
            System.out.print("  ");
            //获得该方法的修饰符并打印
            String modifiers = Modifier.toString(method.getModifiers());
            if (modifiers.length() > 0) {
                System.out.print(modifiers + " ");
            }
            //打印方法名
            System.out.print(method.getName() + "(");

            //获得该方法包含所有参数类型的Class对象的数组
            Class[] paramTypes = method.getParameterTypes();
            //遍历数组
            for (int i = 0; i < paramTypes.length; i++) {
                if (i > 0) {
                    System.out.print(",");
                }
                System.out.print(paramTypes[i].getName());
            }
            System.out.println(");");
        }
    }
}
