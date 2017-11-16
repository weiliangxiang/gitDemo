package cn.gomeplus;

class Person {
	private String  name;
private int age;
public void sop(Object obj){
	System.out.print(obj);
}
Person(){
	sop(name);
}
Person(String name){
	this.name=name;
	sop("B"+name);
}

}
