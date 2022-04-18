# java_learning

1. Comparable
+ Muốn sử dụng cần implement 
+ override function compareTo
+ khi gọi Collections.sort(list), function compareTo được call.


2. Comparator
+ được gọi ngay tại vị trí cần so sánh, không cần implement
+ override function compare
+ Collections.sort(list, new Comparator<E>())