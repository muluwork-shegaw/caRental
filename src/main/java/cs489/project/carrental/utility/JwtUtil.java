package cs489.project.carrental.utility;//package cs489.project.carrental.utility;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class JwtUtil {
    public static final String SECRET = "5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parser()
                .verifyWith(getSignKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private String createToken(Map<String, Object> claims, String subject) {
        var now = Instant.now();
        return Jwts.builder()
                .claims()
                .subject(subject)
                .add(claims)
//                .issuedAt(new Date(System.currentTimeMillis()))
//                .expiration(new Date(System.currentTimeMillis()+1000*60*60*10))
                .issuedAt(Date.from(now))
                .expiration(Date.from(now.plus(24, ChronoUnit.HOURS)))
                .and()
                .signWith(getSignKey())
                .compact();
    }

    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, username);
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())
                && !isTokenExpired(token));
    }

    private SecretKey getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}

//    public static final String SECRET = "5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437";
//    private final UserServiceImpl userService;
//
////    @Value("${app.secret}")
////    private String secret;
//
//    //1 Generate Token ---MANDATORY
//    public String generateToken(String subject) {
//        return Jwts.builder()
//                .setSubject(subject)
//                .setIssuer("maggie")
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + TimeUnit.HOURS.toMillis(24)))
//                .signWith(SignatureAlgorithm.HS512, SECRET.getBytes())
//                .compact();
//    }
//
//    //2. Read claims
//    public Claims getClaims(String token) {
//        return Jwts
//                .parser()
//                .verifyWith(getSignKey())
//                .build()
//                .parseSignedClaims(token)
//                .getPayload();
//    }
//
//    //3 Read Exp Date
//    public Date getExpDate(String token) {
//
//
//        return getClaims(token).getExpiration();
//    }
//
//    //4.Read subject/username
//    public String getUsername(String token) {
//        return getClaims(token)
//                .getSubject();
//    }
//
//    //5 validate Exp Date
//    public boolean isTokenExp(String token) {
//        Date expDate = getExpDate(token);
//        return !(expDate.before(new Date(System.currentTimeMillis())));
//    }
//
//    public boolean validateToken(String token) {
//        try {
//            final String username = getUsername(token);
//            return username.equals(getUserDetails(token).getUsername()) && isTokenExp(token);
//
//        } catch (SignatureException e) {
//            System.out.println(e.getMessage());
//        } catch (MalformedJwtException e) {
//            System.out.println(e.getMessage());
//        } catch (ExpiredJwtException e) {
//            System.out.println(e.getMessage());
//        } catch (UnsupportedJwtException e) {
//            System.out.println(e.getMessage());
//        } catch (IllegalArgumentException e) {
//            System.out.println(e.getMessage());
//        }
//        return false;
//    }
//
//    public Authentication getAuthentication(String token) {
//
//        UserDetails userDetails = getUserDetails(token);
//        var authentication = new UsernamePasswordAuthenticationToken(
//                userDetails, null, userDetails.getAuthorities());
//        return authentication;
//    }
//
//    public UserDetails getUserDetails(String token) {
//        Claims claims = getClaims(token);
//        UserDetails userDetails = userService.loadUserByUsername(claims.getSubject()); // LEFT THIS HERE ON PURPOSE
//        return userDetails;
//
//    }
//
//    private SecretKey getSignKey() {
//        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
//        return Keys.hmacShaKeyFor(keyBytes);
//    }
//}
