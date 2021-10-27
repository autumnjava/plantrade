import React, { useState } from "react";
import DatePicker from "react-datepicker";
import { StyledDatePicker } from "./StyledAuctionDatePicket";

import "react-datepicker/dist/react-datepicker.css";

interface Props {
  endDate: React.Dispatch<React.SetStateAction<number>>;
}

const AuctionDatePicker = ({ endDate }: Props) => {
  let oneMonth = new Date();
  oneMonth.setDate(oneMonth.getDate() + 30);

  let oneDay = new Date();
  oneDay.setDate(oneDay.getDate() + 1);
  const [startDate, setStartDate] = useState(oneDay);

  const handleChange = (date: Date) => {
    setStartDate(date);
    endDate(date.getTime());
  };

  return (
    <StyledDatePicker
      selected={startDate}
      onChange={(date: Date) => handleChange(date)}
      maxDate={oneMonth}
      minDate={oneDay}
    />
  );
};

export default AuctionDatePicker;
