package org.fathos82.notionapi.security;
import org.fathos82.notionapi.user.User;
import org.fathos82.notionapi.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthUserService implements UserDetailsService {
    
    @Autowired
    private UserRepository userRepository;

    public User findByUserName(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Passageiro não encontrado com o nome: " + username));
    }

    @Override
    public AuthUser loadUserByUsername(String username) throws UsernameNotFoundException {
        return new AuthUser(findByUserName(username));
    }
}
