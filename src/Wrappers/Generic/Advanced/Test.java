package Wrappers.Generic.Advanced;

class Test<Test> {
    Test myObj; // Test is placeholder

    Test(Test myObj) {
        this.myObj = myObj;
    }

    public Test getMyObj() {
        return myObj;
    }

}
