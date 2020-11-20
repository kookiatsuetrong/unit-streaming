# unit-streaming
Unit Testing for Streaming Project

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

ระบบขนาดใหญ่ นิยมบังคับชนิดข้อมูลมาด้วย เช่น
```java
List<String> a = new ArrayList<>();
Set<String> s = new HashSet<>();
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

## HashSet 
จะดูที่ hashCode() และ equals()



เข้าไปแล้วจะเจอหน้านี้
![](ide.png)
เลือกอันที่ 3 เลย สะดวกสุด

![](folder.png)

