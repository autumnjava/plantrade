import styled from "styled-components";
import PersonIcon from '@mui/icons-material/Person';
import VpnKeyIcon from '@mui/icons-material/VpnKey';
import AlternateEmailIcon from '@mui/icons-material/AlternateEmail';


export const StyledWrapper = styled.div`
  
`;

export const StyledForm = styled.form`
  width: 70%;
  margin: 0 auto;
`;

export const StyledInputDiv = styled.div`
  display: grid;
  grid-gap: 10px;

  grid-template-columns: 12% 1fr;

`;

export const StyledInput = styled.input`
  outline: none;
  border: none;
  border-bottom: 1px solid grey;
  font-size: 17px;
  margin-top: 20px;
  &:focus{
    border-bottom: 1px solid green;
  }
`;

export const StyledBtn = styled.button`
  border: none;
  outline: none;
  padding: 10px;
  font-size: 15px;
  border-radius: 3px;
  background-color: #619463;
  color: white;
  width: 100%;
  margin-top: 15px;
`;

export const StyledPorfileIcon = styled(PersonIcon)`
  width: 20px;
  color: grey;
  margin-top: 15px;
`;

export const StyledPwIcon = styled(VpnKeyIcon)`
  width: 20px;
  color: grey;
  margin-top: 15px;
`;

export const StyledEmailIcon = styled(AlternateEmailIcon)`
  width: 20px;
  color: grey;
  margin-top: 15px;
`;

export const StyledTitle = styled.p`
  text-align: center;
  font-size: 20px;
  letter-spacing: 1.5px;
`;

export const StyledText = styled.p`
  color: red;
  text-align: center;
  margin: 0;
  padding-top: 10px;
  font-size: 16px;
`;