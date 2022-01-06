package exception_;
/* 
    Author: whiplash
    Date: 2021/11/24 23:06
*/


public class CustomException {
    public static void main(String[] args) {
        int age = 100;
        if(!(age>=20 && age<=80)) {
            throw new AgeException("年龄需要在20~80之间");
        }
    }
}
// 自定义异常一般继承 RuntimeException
// 如果继承 Exception，那么就是编译异常，还要对异常进行处理
class AgeException extends RuntimeException {
    public AgeException(String message) { // 构造器
        super(message);
    }
}