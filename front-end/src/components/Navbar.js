    import * as React from 'react';
    import { Box, AppBar, Toolbar, Typography, TableRow, Table } from '@mui/material';
    import { useNavigate } from 'react-router-dom';
    // import NavButton from './NavButton';
    // import LogoButton from './LogoButton';
    import styles from './Buttons.module.css';
    import sharklogo from '../assets/sharklogo.png';

    export default function Navbar() {
        const navigate = useNavigate();
        const navigateToAbout = () => {
            navigate('/about')
        }
        const navigateToGroup = () => {
            navigate('/group')
        }
        const navigateToSingle = () => {
            navigate('/single')
        }
        const navigateToBoard = () => {
            navigate('/board')
        }
        const navigateToMyPage = () => {
            navigate('/mypage')
        }
        const navigateToRegister = () => {
            navigate('/register')
        }
        const navigateToSignIn = () => {
            navigate('/login');
        };
        const navigateToMain = () => {
            navigate('/');
        };
        return (
        <Box sx={{flexGrow:1}}>
            <AppBar position="static" sx={{bgcolor: "#997B66"}} >
                <Toolbar style={{height:100}}>

                    <Typography variant="h4" component="div" sx={{ flexGrow: 1 }} style={{width:"20%", margin:"3%"}}>
                        <table>
                            
                            <div className={styles.logoBtn} onClick={navigateToMain}>
                            <img src={sharklogo}/>
                            {/* <tr><td><img src={sharklogo}/></td>
                            <td>악기</td>
                            <td>상어</td>
                            </tr> */}
                            
                            </div>
                        </table>
                        

                    </Typography>

                        <Table style={{width:"100%", marginRight:0}}>
                                <colgroup>
                                    <col style={{width:"20%"}}/>
                                    <col style={{width:"20%"}}/>
                                    <col style={{width:"20%"}}/>
                                    <col style={{width:"20%"}}/>
                                    <col style={{width:"20%"}}/>
                                    <col style={{width:"20%"}}/>
                                </colgroup>
                            
                        <TableRow>
                            <td colSpan={4} style={{textAlign:'right'}}>
                            <div className={styles.loginBtn} onClick={navigateToSignIn}>
                            Login
                            </div>
                            </td>
                        </TableRow>
                        <TableRow>
                            <td>
                                <div className={styles.navBtn} onClick={navigateToAbout}>
                                    악기상어 소개
                                </div>
                            </td>
                            <td>
                                <div className={styles.navBtn} onClick={navigateToGroup}>
                                    함께 연습하기
                                </div>
                            </td>
                            <td>
                                <div className={styles.navBtn} onClick={navigateToSingle}>
                                    혼자 연습하기
                                </div>
                            </td>
                            <td>
                                <div className={styles.navBtn} onClick={navigateToBoard}>
                                    커뮤니티
                                </div>
                            </td>
                            <td>
                                <div className={styles.navBtn} onClick={navigateToMyPage}>
                                    마이페이지
                                </div>
                            </td>
                        </TableRow>
                    </Table>

                    {/* 로그인/로그아웃 배치 */}
                </Toolbar>
            </AppBar>
        </Box >
    );
}
