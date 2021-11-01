import styled from "styled-components";
import { Collapse, IconButton } from '@mui/material'

export const StyledCollapse = styled(Collapse)`
  background: var(--yellow);
  width: 100%;
  border-radius: 5px;
  max-height: 500px;
`;
export const StyledDiv = styled.div`
  background: var(--light-yellow);
  width: 90%;
  margin: 3% auto;
  border-radius: 5px;
  padding: 3%;
  max-height: 400px;
`;

export const StyledTitle = styled.p`
  padding: 40px 10px 10px;
  margin: 0;
  font-family: var(--font-text);
`;

export const StyledIconButton = styled(IconButton)`
  position: absolute;
  right: 5%;
`;