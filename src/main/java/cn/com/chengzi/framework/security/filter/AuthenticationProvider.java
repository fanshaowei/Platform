package cn.com.chengzi.framework.security.filter;

import org.apache.log4j.Logger;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

public class AuthenticationProvider extends DaoAuthenticationProvider{
    private static final Logger logger = Logger.getLogger(AuthenticationProvider.class);
    
    /**
	 * 对明文进行加密
	 * 
	 * @param plain
	 *            明文
	 * @return 密文
	 */
	@SuppressWarnings("deprecation")
	public String encoding(String plain) {

		SaltSource saltSource = this.getSaltSource();
		if (saltSource != null) {
			return getPasswordEncoder().encodePassword(plain,
					saltSource.getSalt(null));
		} else {
			return getPasswordEncoder().encodePassword(plain, null);
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		Object salt = null;

		if (getSaltSource() != null) {
			salt = getSaltSource().getSalt(userDetails);
		}

		if (authentication.getCredentials() == null) {
			logger.debug("Authentication failed: no credentials provided");

		}

		String userName = authentication.getName();

		String presentedPassword = authentication.getCredentials().toString();

		if (!getPasswordEncoder().isPasswordValid(userDetails.getPassword(),
				presentedPassword, salt)) {
			logger.debug("Authentication failed: password does not match stored value");

			logger.error("userName," + userName + ";Password,"
					+ presentedPassword + " login failed!");
		}

		logger.info("userName," + userName + ";Password," + presentedPassword
				+ " login success!");

	}
	
}
