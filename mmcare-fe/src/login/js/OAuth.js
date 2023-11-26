
/**
 *  KAKAO LOGIN ACCESS TOKEN URL 
 * */
const KAKAO_API_KEY = '53e47295bcafa934bd27aa2b6a07b1f7'
const REDIRECT_URL = 'http://localhost:3000'

export const KAKAO_API_URL = `https://kauth.kakao.com/oauth/authorize?client_id=${KAKAO_API_KEY}&redirect_uri=${REDIRECT_URL}&response_type=code`;
export const REQUEST_URL = 'http://localhost:8080/';