package study;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.TreeSet;

interface jdkinterface {
    void print() ;
}
class jdkclass implements  jdkinterface{
    @Override
    public void print() {
        System.out.println("jdkclass method run");
    }
}

class myInvocationhandler implements InvocationHandler{
    private Object target;

    public myInvocationhandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("enhance method");
        method.invoke(target,args);
        return target;
    }

    public static void main(String[] args) {
        jdkclass jdkclass = new jdkclass();
        myInvocationhandler myInvocationhandler  = new myInvocationhandler(jdkclass);
        jdkinterface jdi = (jdkinterface) Proxy.newProxyInstance(jdkclass.getClass().getClassLoader(),jdkclass.getClass().getInterfaces(),myInvocationhandler);
        jdi.print();

    }
}
