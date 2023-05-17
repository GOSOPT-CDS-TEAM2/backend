package sopt.org.oliveyoungServer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.org.oliveyoungServer.infrastructure.CartRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
}
