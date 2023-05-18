package sopt.org.oliveyoungServer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.org.oliveyoungServer.domain.CartProduct;
import sopt.org.oliveyoungServer.infrastructure.CartProductRepository;
import sopt.org.oliveyoungServer.infrastructure.CartRepository;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CartProductService {
    private final CartProductRepository cartProductRepository;

    @Transactional
    public int addCount(CartProduct cartProduct){
        int modifyCount = cartProduct.getCount()+1;
        cartProduct.setCount(modifyCount);
        return cartProduct.getCount();
    }

    @Transactional
    public int subtractCount(CartProduct cartProduct){
        int modifyCount = cartProduct.getCount()-1;
        if(modifyCount<0){
            cartProduct.setCount(1);
        }
        else {
            cartProduct.setCount(modifyCount);
        }
        return cartProduct.getCount();
    }
}
