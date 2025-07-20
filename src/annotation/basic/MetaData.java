package annotation.basic;

import java.lang.annotation.Annotation;

@AnnoMeta
public class MetaData {

//    @AnnoMeta 필드 적용 (x)
    private String id;

    @AnnoMeta
    public void call() {

    }

    public static void main(String[] args) throws NoSuchMethodException {
        AnnoMeta annotation = MetaData.class.getAnnotation(AnnoMeta.class);
        System.out.println("annotation = " + annotation);

        Annotation call = MetaData.class.getMethod("call").getAnnotation(AnnoMeta.class);
        System.out.println("call = " + call);
    }
}
