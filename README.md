# Streaming Project

## Collections

ทั้ง List, Set และ Map เป็น interface
* ArrayList และ LinkedList เป็น Implementation ของ List
* HashSet กับ TreeSet เป็น Implementation ของ Set
* HashMap กับ TreeMap เป็น Implementation ของ Map

```
'-- List
'   '-- ArrayList
'   '-- LinkedList
'-- Set
'   '-- HashSet
'   '-- TreeSet
'-- Map
    '-- HashMap
    '-- TreeMap
```

ระบบขนาดใหญ่ นิยมบังคับชนิดข้อมูล และตั้งชื่อตัวแปรเป็น Plural เช่น
```java
List<String> data = new ArrayList<>();
Set<String> users = new HashSet<>();
```

Method ที่ควรรู้
```java
add("Latte")      // ใส่คำว่า "Latte" เข้าไป

remove("Latte")   // เอาคำว่า "Latte" ตัวแรกออกไป

contains("Latte") // ตรวจสอบดูว่ามี "Latte" หรือเปล่า

size()            // จำนวนข้อมูลที่มีทั้งหมด
```

ใช้ Enhanced For-Loop จะง่ายกว่า
```java
Set<String> users = new HashSet<>();
users.add("Frank L");
users.add("David B");
for (String s : users) {
    System.out.println(s);
}
```

พวก Primitive Data จะถูกแปลงเป็น Instance 
```java
List<Integer> a = new ArrayList<>();
a.add(5);
a.add(7);
for (Integer i : a) {
    if (i instanceof Integer) {
        System.out.println("OK");
    }
}
```

ตัวอย่างการเขียน Method นับเลขคู่จาก List<Integer>
```java
int count(List<Integer> data) {
    int t = 0;
    for (Integer e : data) {
        if (e % 2 == 0) {
            t++;
        }
    }
    return t;
}
```
แบบฝึกหัด จาก Class ที่กำหนดให้ เขียน Method หาว่ามี Square กี่อัน
```java
class Rectangle {
    public Rectangle(double w, double h) {
        this.width = w;
        this.height = h;
    }
    double width, height;
    public double getWidth() { return width; }
    public double getHeight() { return height; }
}
class Sample {
    int count(List<Rectangle> data) {
        .
        .
        .
    }
}
```
ระบบขนาดใหญ่ต้องอ่านข้อมูลผ่าน getter เท่านั้น
และเปลี่ยนข้อมูลผ่าน setter แต่ในตัวอย่างด้านบนไม่มี

## List
List คือโครงสร้างข้อมูลที่เพิ่มข้อมูลเข้ามาได้ ไม่ต้องรู้ขนาดก่อนล่วงหน้า
ใน Java มี 2 แบบคือ ArrayList และ LinkedList
* ArrayList คือ List ที่สร้างมาจาก Array
* LinkedList คือ List ที่สร้างมาจากการ Linked หรือ เชื่อมโยงนั่นเอง

List สามารถเก็บตัวซ้ำได้ ถ้าต้องการ Sort ข้อมูลต้องมีคุณสมบัติ Comparable ด้วย
แต่การเขียน Comparable ค่อนข้างยาก และต้องไปแก้ Class ให้รองรับ
ดังนั้น ถ้าต้องการ Sort ข้อมูล เปลี่ยนไปใช้แบบ Comparator จะง่ายกว่า เช่น

```
Collections.sort(data, (x,y) -> x.getName().compareTo(y.getName()) );
```

ตัวอย่างการเรียงข้อมูลตามชื่อใน ArrayList ด้วย Comparator
```java
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
class Start {
	public static void main(String[] z) {
		List<Student> data = new ArrayList<>();
		data.add(new Student("Clare", 163.0));
		data.add(new Student("Bob", 167.0));
		data.add(new Student("David", 170.0));
		data.add(new Student("Alice", 167.0));
		Collections.sort(data, (x,y) -> x.getName().compareTo(y.getName()) );
		for (Student s : data) {
			System.out.println(s.name);
		}
	}
}
class Student {
	public Student(String name, double height) {
		this.name = name;
		this.height = height;
	}
	final String name;
	final double height;
	public String getName() {
		return name;
	}
	public double getHeight() {
		return height;
	}
}
```

ตัวอย่างการเรียงตามความสูงน้อยไปมาก แต่ถ้าความสูงเท่ากันก็เปรียบเทียบตามชื่อ
```java
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
class Start {
	public static void main(String[] z) {
		List<Student> data = new ArrayList<>();
		data.add(new Student("Clare", 163.0));
		data.add(new Student("Bob", 167.0));
		data.add(new Student("David", 170.0));
		data.add(new Student("Alice", 167.0));
		Collections.sort(data, (x,y) -> {
			if (x.getHeight() < y.getHeight()) return -1;
			if (x.getHeight() > y.getHeight()) return +1;
			return x.getName().compareTo(y.getName());
		});
		for (Student s : data) {
			System.out.println(s.name);
		}
	}
}
class Student {
	public Student(String name, double height) {
		this.name = name;
		this.height = height;
	}
	final String name;
	final double height;
	public String getName() {
		return name;
	}
	public double getHeight() {
		return height;
	}
}
```

## HashSet 
Set คือโครงสร้างการเก็บข้อมูลที่จะไม่เก็บตัวซ้ำ
มี 2 ตัวเหมือนกันคือ TreeSet และ HashSet
ข้อมูลที่ใส่ใน TreeSet ต้องเป็น Comparable 
จะเขียนยากต้องแก้ Class เสียเวลาเปล่า
ส่วน HashSet น่าจะง่ายกว่า
ในคำสั่ง add() ของ HashSet จะเรียก hashCode() 
เพื่อหา Slot ที่เหมาะสม 
และเรียก equals() เพื่อหาตัวซ้ำใน Slot นั้น
ถ้าไม่มีตัวซ้ำก็ใส่ข้อมูลเข้าไป

บาง Class ใช้จำนวนเต็มเป็นหมายเลขประจำตัว หรือ รหัสข้อมูล
ก็ใช้เป็น hashCode() ได้ เช่น
```java
class Staff {
    int code;

    @Override 
    public int hashCode() {
        return code;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Staff) {
            Staff s = (Staff)o;
            return code == s.code;
        } else {
            return false;
        }
    }
}
```

หรือบาง Class ใช้ String เช่น Bar Code สินค้า
ก็ส่ง hashCode() ของ String ออกมาแทน เช่น
```java
class Staff {
    String code;

    @Override 
    public int hashCode() {
        return code.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Staff) {
            Staff s = (Staff)o;
            return code.equals(s.code);
        } else {
            return false;
        }
    }
}
```

## แบบทดสอบ
เข้าไปแล้วจะเจอหน้านี้
![](ide.png)
เลือกอันที่ 3 เลย สะดวกสุด

ตัวอย่างแบบทดสอบ
![](folder.png)

