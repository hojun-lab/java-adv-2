package annotation.basic;

import util.MyLogger;

import java.util.Arrays;

public class ElementData1Main {
    public static void main(String[] args) {
        Class<ElementData1> elementData1Class = ElementData1.class;
        AnnoElement element = elementData1Class.getAnnotation(AnnoElement.class);

        String value = element.value();
        System.out.println("value = " + value);

        int count = element.count();
        System.out.println("count = " + count);

        String[] tags = element.tags();
        System.out.println("tags = " + Arrays.toString(tags));
    }
}
