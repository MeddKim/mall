package com.doge;

public class Doge {

    //framework初始化标记
    private static boolean initialized = false;

    /**
     * 模块枚举
     */
    public enum DogeModule {
        CORE,
        BEAN,
        VTOR;

//        static {
//            initAllModules();
//        }

        private Class<?> moduleClass;

        /**
         * 模块加载
         */
        private synchronized void load(){
            System.out.println("---"+this.name()+"模块开始加载---");
        }
    }

    //Doge类加载时调用
    static {
        initAllModules();
    }

    private synchronized static void initAllModules(){
        System.out.println("---Doge类初始化---");
        //true==initialized,已初始化，无需再次初始化
//        if(initialized){
//            return;
//        }
        for (DogeModule dogeModule: DogeModule.values()){
            dogeModule.load();
        }

    }

    public static void main(String[] args) {
        System.out.println("你好");
    }
}
