package sopt.org.oliveyoungServer.domain;

import java.io.Serializable;
import java.util.Objects;

public class ProductTagId implements Serializable {
    private Product product;
    private Tag tag;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductTagId that = (ProductTagId) o;
        return Objects.equals(product, that.product) && Objects.equals(tag, that.tag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, tag);
    }
}
