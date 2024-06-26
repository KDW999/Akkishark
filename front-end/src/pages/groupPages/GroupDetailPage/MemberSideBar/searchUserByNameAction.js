import axios from "axios";
import { getCookie } from "../../../../util/cookie";

export const searchUserByNameAction = async (name, setSearchData) => {
    const URL = process.env.REACT_APP_API_URL
    const accessToken = getCookie('accessToken')
    const changeValue = (value) => {
        setSearchData(value)
    }
    try {
        const response = await axios({
            method: 'get',
            url: `${URL}/friend/nickname-search-list/?userNickname=${name}`,
            headers: {
                Authorization: `Bearer ${accessToken}`
            }
        })
        changeValue(response.data.data)
    } catch (err) {
        console.log(err)
    }
}

