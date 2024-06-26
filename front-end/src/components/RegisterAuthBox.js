import React from 'react';
import Box from '@mui/material/Box'
import { styled } from '@mui/system';
import styles from './AuthBox.module.css'

const BoxWrapper = styled('div')({
    width: '100%',
    height: '100vh',
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'center',
    background: '#FFEDD8'
})

const RegisterAuthBox = (props) => {
    return (
        <div className={styles.boxWrapper}>
            <Box
                sx={{
                    width: 700,
                    height: '70vh',
                    bgcolor: '#ffffff',
                    borderRadius: '5px',
                    boxShadow: '0 2px 10px 0 rgb(0 0 0.5/ 20%)',
                    display: 'flex',
                    flexDirection: 'column',
                    padding: '25px',
                    overflow:'scroll',

                }}
            >
                {props.children}
            </Box>
        </div>
    )
}

export default RegisterAuthBox