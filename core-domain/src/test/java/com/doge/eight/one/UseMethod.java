package com.doge.eight.one;

import java.io.File;

public class UseMethod {

    public File[] getHideFile(String path){

        /**
         * 传统方式
        new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isHidden();
            }
        });
         */

        return new File(".").listFiles(File::isHidden);
    }

}
