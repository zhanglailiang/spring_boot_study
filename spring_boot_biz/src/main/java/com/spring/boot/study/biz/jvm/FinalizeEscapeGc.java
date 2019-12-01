package com.spring.boot.study.biz.jvm;

/**
 * @program: spring_boot_study
 * @description:
 * @author: zhanglailiang
 * @create: 2019-04-03 19:06
 **/
public class FinalizeEscapeGc {

    public  static FinalizeEscapeGc SAVE_HOOK = null;

    public void isAlive() {
        System.out.println ("yes  i am still alive");
    }

    protected void finalize() throws Throwable {
        super.finalize ();
        System.out.println ("finalize method executed");
        FinalizeEscapeGc.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGc ();
        SAVE_HOOK = null;
        System.gc ();
//        Thread.sleep (500);

        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive ();
        } else {
            System.out.println ("no  i am dead");
        }

        SAVE_HOOK = null;
        System.gc ();
        Thread.sleep (500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive ();
        } else {
            System.out.println ("no  i am dead");
        }
    }

    /**
     * 从代码清单2-16 的运行结果可以看到， SAVE_HOOK 对象的finalize （）方法确实被GC 收集
     * 器触发过，并且在被收集前成功逃脱了。另外一个值得注意的地方就是，代码中有两段完全一
     * 样的代码片段，执行结果却是一次逃脱成功， 一次失败，这是因为任何一个对象的finalize （）方
     * 法都只会被系统自动调用一次，如果对象面临下一次回收，它的finalize （）方法不会被再次执行，
     * 因此第2 段代码的自救行动失败了。
     */

}
