package cpsexamples;

public class Fib {
    
    public Fib() {
        
    }

    public int getFib(int n){
        NewMainClass object = new NewMainClass();
        object.fib(n, new Continuation());
        return object.____FIB_VAL;
    }
}

class NewMainClass {
    int ____FIB_VAL ;

    public void fib (int n , Continuation k) {
        int temp ;
        NewMainClass curr ;
        NewMainClass
                pseudoThis ;
        ContinuationClass_ContinuationMethod1 k1 ;
        pseudoThis = this;
        if ( n < 3 ) {
            ____FIB_VAL = 1;
            k.call();
        }
        else {
            curr = this;
            k1 = new ContinuationClass_ContinuationMethod1();
            k1.n = n ;
            k1.curr = curr;
            k1.k = k;
            k1.object = this;
            curr.fib(n - 1 , k1);
        }
    }

    public void continuationMethod0 (int arglength ,
                                     Continuation k ) {
        NewMainClass pseudoThis ;
        pseudoThis = this;
        System.out.println ( ____FIB_VAL ) ;
        k.call();
    }

    public void continuationMethod2 (int n , NewMainClass curr , int temp ,
                         Continuation k ) {
        NewMainClass pseudoThis ;
        pseudoThis = this;
        ____FIB_VAL = temp + ____FIB_VAL;
        k.call();
    }

    public void continuationMethod1 (int n , NewMainClass curr , Continuation
                         k ) {
        int temp ;
        NewMainClass pseudoThis ;
        ContinuationClass_ContinuationMethod2 k1 ;
        pseudoThis = this;
        temp = ____FIB_VAL;
        k1 = new ContinuationClass_ContinuationMethod2();
        k1.n = n;
        k1.curr = curr;
        k1.temp = temp;
        k1.k = k;
        k1.object = this;
        curr.fib(n - 2 , k1);
    }
}

class ContinuationClass_ContinuationMethod0 extends Continuation {
    int
    arglength ;
    Continuation k ;
    NewMainClass object ;
    public void call () {
        object.continuationMethod0(arglength , k);
    }
}

class ContinuationClass_ContinuationMethod2 extends Continuation {
    int n ;
    NewMainClass curr ;
    int temp ;
    Continuation k ;
    NewMainClass object ;
    public void call () {
        object. continuationMethod2(n , curr , temp , k);
    }
}

class ContinuationClass_ContinuationMethod1 extends Continuation {
    int n ;
    NewMainClass curr ;
    Continuation k ;
    NewMainClass
    object ;
    public void call () {
        object.continuationMethod1(n , curr , k);
    }
}

class Continuation {
    public void call () {
    }
}
