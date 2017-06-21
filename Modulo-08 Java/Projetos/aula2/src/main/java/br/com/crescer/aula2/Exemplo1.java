package br.com.crescer.aula2;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author carloshenrique
 */
public class Exemplo1 {

    public static void main(String[] args) throws IOException {
        final File file = new File(".");
//        System.out.println(file.createNewFile());

        Arrays.asList(file.listFiles(new FileFilter() {
            @Override
            public boolean accept(final File pathname) {
                return pathname.getName().contains(".txt");
            }
        })).stream()
                .map(File::getAbsolutePath)
                .forEach(System.out::println);
    }
}
