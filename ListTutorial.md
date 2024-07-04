Tutorial: Lists in Java

1. Introduction to Lists

Lists in Java are ordered collections that allow duplicate elements. They're part of the Java Collections Framework and provide a way to store and manipulate groups of objects.

The List interface extends the Collection interface and is typically used when you need:

- An ordered collection
- Access to elements by their integer index
- To allow duplicate elements

2. Creating Lists

There are several ways to create a List in Java:

Example 1: Using ArrayList (most common implementation)

```java
List<String> fruits = new ArrayList<>();
fruits.add("Apple");
fruits.add("Banana");
fruits.add("Cherry");
```

Example 2: Using Arrays.asList() for a fixed-size list

```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
```

Example 3: Using List.of() (Java 9+) for an immutable list

```java
List<String> colors = List.of("Red", "Green", "Blue");
```

3. Common List Operations

a) Adding elements:

```java
List<String> animals = new ArrayList<>();
animals.add("Dog");  // Adds to the end of the list
animals.add(0, "Cat");  // Adds at specific index
```

b) Accessing elements:

```java
String firstAnimal = animals.get(0);  // Returns "Cat"
```

c) Updating elements:

```java
animals.set(1, "Elephant");  // Replaces "Dog" with "Elephant"
```

d) Removing elements:

```java
animals.remove("Cat");  // Removes by object
animals.remove(0);  // Removes by index
```

e) Checking size and emptiness:

```java
int size = animals.size();
boolean isEmpty = animals.isEmpty();
```

4. Iterating Over Lists

There are several ways to iterate over a List:

a) Using for-each loop:

```java
List<String> fruits = Arrays.asList("Apple", "Banana", "Cherry");
for (String fruit : fruits) {
    System.out.println(fruit);
}
```

b) Using traditional for loop:

```java
for (int i = 0; i < fruits.size(); i++) {
    System.out.println(fruits.get(i));
}
```

c) Using Iterator:

```java
Iterator<String> iterator = fruits.iterator();
while (iterator.hasNext()) {
    System.out.println(iterator.next());
}
```

d) Using forEach method (Java 8+):

```java
fruits.forEach(System.out::println);
```

5. List and Lambdas

Lists work well with lambda expressions, especially for operations like filtering or mapping:

a) Filtering a list:

```java
List<String> longFruits = fruits.stream()
                                .filter(f -> f.length() > 5)
                                .collect(Collectors.toList());
```

b) Mapping a list:

```java
List<Integer> fruitLengths = fruits.stream()
                                   .map(String::length)
                                   .collect(Collectors.toList());
```

6. Understanding the Project Code

Now let's examine the code from your project:

```java
public List<Post> getAllPosts() {
    List<Post> posts = postRepository.findAll();
    posts.forEach(this::fetchAndSetUserDetails);
    return posts;
}
```

This method:

1. Creates a List of Post objects by calling `findAll()` on the repository.
2. Uses the `forEach` method of List to apply `fetchAndSetUserDetails` to each Post in the list.
3. Returns the processed List of Posts.

The `posts.forEach(this::fetchAndSetUserDetails)` line demonstrates how Lists can be used with method references to process each element.

Practice Questions:

1. Create a List of integers and write a method to return the sum of all even numbers in the list.

Answer:

```java
public int sumEvenNumbers(List<Integer> numbers) {
    return numbers.stream()
                  .filter(n -> n % 2 == 0)
                  .mapToInt(Integer::intValue)
                  .sum();
}

List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);
System.out.println(sumEvenNumbers(nums));  // Output: 12
```

2. Given a List of strings, write a method to return a new List containing only the strings that start with a vowel.

Answer:

```java
public List<String> filterVowelStart(List<String> words) {
    return words.stream()
                .filter(w -> "aeiouAEIOU".indexOf(w.charAt(0)) != -1)
                .collect(Collectors.toList());
}

List<String> words = Arrays.asList("Apple", "Banana", "Orange", "Pear");
System.out.println(filterVowelStart(words));  // Output: [Apple, Orange]
```

3. Write a method that takes a List of integers and returns a new List with each number squared, using the `map` operation.

Answer:

```java
public List<Integer> squareNumbers(List<Integer> numbers) {
    return numbers.stream()
                  .map(n -> n * n)
                  .collect(Collectors.toList());
}

List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
System.out.println(squareNumbers(nums));  // Output: [1, 4, 9, 16, 25]
```

This tutorial covers the basics of Lists in Java, their creation, common operations, iteration methods, and their use with lambda expressions. It also relates these concepts to the code snippet from your project, demonstrating how Lists are fundamental to many Java applications, especially when working with collections of objects like posts in a blog application.
