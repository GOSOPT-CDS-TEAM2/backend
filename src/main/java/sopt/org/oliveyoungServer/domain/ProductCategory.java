package sopt.org.oliveyoungServer.domain;

public enum ProductCategory {

    BODYCARE("바디케어"),
    HAIRCARE("헤어케어"),
    PERFUMEANDDEFUSER("향수/디퓨저"),
    BEAUTYTOOL("미용소품"),
    MAN("남성"),
    FOOD("식품"),
    PET("반려동물"),

    ETC("기타");

    private String name;

    private ProductCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static ProductCategory nameOf(String name) {
        for (ProductCategory category : ProductCategory.values()) {
            if (category.getName().equals(name)) {
                return category;
            }
        }
        return ETC;
    }
}
