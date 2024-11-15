/*https://leetcode.com/problems/simplify-path/description/*/

/*
            The rules of a Unix-style file system are as follows:

        A single period '.' represents the current directory.
        A double period '..' represents the previous/parent directory.
        Multiple consecutive slashes such as '//' and '///' are treated as a single slash '/'.
        Any sequence of periods that does not match the rules above should be treated as a valid directory or file name. For example, '...' and '....' are valid directory or file names.
        The simplified canonical path should follow these rules:

        The path must start with a single slash '/'.
        Directories within the path must be separated by exactly one slash '/'.
        The path must not end with a slash '/', unless it is the root directory.
        The path must not have any single or double periods ('.' and '..') used to denote current or parent directories.
  */

package linear;

import java.util.*;

public class SimplifyPath {
    public static String simplifyPath(String path) {

        if(path.equals("/")) {
            return path;
        }
        String output = adjustDirectoryPath(path);
        return output.equals("")?"/":output;
    }

    private static String adjustDirectoryPath(String correctPath) {

        final StringBuilder output = new StringBuilder();
        List<String> directories = new ArrayList<>();
        for(String x : correctPath.split("/")) {

            if (x.equals(".")) {
            } else {
                if (x.equals("..")) {
                    if (!directories.isEmpty()) {

                        directories.remove(directories.size() - 1);
                    }
                } else {
                    if(!x.equals("")) {
                        directories.add(x);
                    }
                }
            }
        }

        for(String directory:directories) {
            if(!directory.equals("")) {
                output.append("/").append(directory);
            }
        }

        return output.toString();

    }


//    private static String reduceSlashes(String path) {
//        final StringBuilder output = new StringBuilder();
//        //path=path.replace("/./","/");
//
//        for(String x : path.split("/")) {
//            if(!x.equals("")) {
//                output.append("/"+x);
//            }
//        }
//
//        return output.toString();
//    }




    public static void main(String [] args) {
        String a = "/.../a/../b/c/../d/./";
        String b = "/.../a/../b/c/../d/./x////y"; // output=/.../b/d
        String c = "/a/../../b/../c//.//";
        String d = "/a//b////c/d//././/..";
        String e = "/.././em/jl///../.././../E/";
//        for(String x : a.split("//")) {
//            System.out.println(x);
//        }
        System.out.println("output="+simplifyPath(e));
        //System.out.println(reduceSlashes(a));
    }
}
