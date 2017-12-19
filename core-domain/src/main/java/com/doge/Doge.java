package com.doge;

import java.lang.reflect.InvocationTargetException;

public class Doge {

    //framework初始化标记
    private static boolean initialized = false;

    /**
     * 模块枚举
     */
    public enum DogeModule {
        CORE,
        BEAN;
//        VTOR;

//        static {
//            initAllModules();
//        }

        private Class<?> moduleClass;

        /**
         * 模块加载
         * 实际上是加载每个模块核心类，如 com.doge.bean.DogeBean  com.doge.core.DogeCore
         */
        private synchronized void load(){
            //若加载过了就无需再次加载
            if(this.moduleClass != null){
                return;
            }
            System.out.println("---"+this.name()+"模块开始加载---");

            final String moduleClassName = resolveClassName(this);

            System.out.println("--加载模块:"+moduleClassName);
            try {
                this.moduleClass = Doge.class.getClassLoader().loadClass(moduleClassName);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        private synchronized  void start(){
            if (!Doge.isModuleLoaded(this)){
                return;
            }
            try {
                moduleClass.getDeclaredConstructor().newInstance();
            } catch (Exception e){
            }
        }

    }

    //Doge类加载时调用
    static {
        initAllModules();
    }

    private synchronized static void initAllModules(){
        System.out.println("---初始化所有模块---");
        //true==initialized,已初始化，无需再次初始化
//        if(initialized){
//            return;
//        }
        for (DogeModule dogeModule: DogeModule.values()){
            dogeModule.load();
        }

    }

    private static String resolveClassName(DogeModule dogeModule){
        String moduleName = dogeModule.name();   //CORE,BEAN 等

        String packageName = moduleName.toLowerCase(); //小写


        //去掉所有下划线
        while (true){
            int ndx = packageName.indexOf("-");

            if(-1 == ndx)
                break;

            packageName = packageName.substring(0, ndx) +
                    packageName.substring(ndx + 1);
        }

        //模块首字母大写
        moduleName = moduleName.substring(0,1).toUpperCase() +
                moduleName.substring(1,moduleName.length()).toLowerCase();

        //将下划线改成驼峰式模块名
        while (true){
            int ndx = moduleName.indexOf("-");

            if(-1 == ndx)
                break;

            moduleName = moduleName.substring(0, ndx) +
                    moduleName.substring(ndx + 1,ndx + 2).toUpperCase() +
                    moduleName.substring(ndx + 2);
        }

        return "com.doge." + packageName + ".Doge"+moduleName;
    }

    /**
     * 模块初始
     */
    public static void initModule(){
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

        for(StackTraceElement stackTraceElement : stackTrace){
            String className = stackTraceElement.getClassName();

            for(DogeModule dogeModule: DogeModule.values()){
                if(className.equals(resolveClassName(dogeModule))){
                    dogeModule.load();
                }
                return;
            }
        }
    }

    /**
     * 模块是否已经加载
     *   true : 是
     *   false: 否
     * @param dogeModule
     * @return
     */
    public static boolean isModuleLoaded(DogeModule dogeModule){
          return dogeModule.moduleClass != null;
    }


    public static void main(String[] args) {
        System.out.println("你好");
    }
}
