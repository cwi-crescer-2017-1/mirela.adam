package br.com.crescer.exerciciosaula2;
/**
 *
 * @author Mirela
 */
public interface FileUtils {

    boolean mk(String string);

    boolean rm(String string);

    String ls(String string);

    boolean mv(String in, String out);
}
