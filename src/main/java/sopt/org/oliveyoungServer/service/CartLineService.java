package sopt.org.oliveyoungServer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sopt.org.oliveyoungServer.infrastructure.CartRepository;

@Service
@RequiredArgsConstructor
public class CartLineService {
    private final CartRepository cartRepository;
}
