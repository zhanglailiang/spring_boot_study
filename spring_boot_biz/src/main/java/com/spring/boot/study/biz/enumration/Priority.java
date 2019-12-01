package com.spring.boot.study.biz.enumration;

/**
 * @program: spring_boot_study
 * @description:
 * @author: zhanglailiang
 * @create: 2019-03-19 20:20
 **/
public enum Priority implements Command {

    STOP {
        public void execute() {
            System.out.println ("stop");
        }
    },

    START {
        public void execute() {
            System.out.println ("stop");
        }
    },

    RUN {
        public void execute() {
            System.out.println ("stop");
        }
    },

    BREAK {
        public void execute() {
            System.out.println ("stop");
        }
    },


    ;

    public static void main(String[] args) {
        Priority start = Priority.START;
        start.execute ();

    }

}
