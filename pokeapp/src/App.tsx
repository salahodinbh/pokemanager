import { useEffect, useState } from 'react'
import './App.css'
import { getTrainers } from './api/TrainerService';
import Header from './components/Header';
import {Routes, Route, Navigate} from 'react-router-dom';
import TrainerList from './components/TrainerList';
import { Trainer, TrainerPaginatedResponse } from './types/trainer-type';

function App() {
  const [data, setData] = useState<TrainerPaginatedResponse<Trainer>>({
    content: [],
    totalPages: 0,
    totalElements: 0
  });

  const [currentPage, setCurrentPage] = useState<number>(0);

  const getAllTrainers = async (page = 0, size = 10) => {
    try {
      setCurrentPage(page);
      const {data} =  await getTrainers(page, size);
      setData(data);
    } catch (error) {
      console.log(error);
    }
  }

  const toggleModal = (show: boolean) => {
  }

  useEffect(() => {
    getAllTrainers();
  }, []);

  return (
    <>
      <Header toggleModal={toggleModal} nbOfTrainers={data?.totalElements} />
      <Routes>
        <Route path='/' element={<Navigate to={"/trainers"} />} /> 
        <Route path="/trainers" element={<TrainerList data={data} currentPage={currentPage} getAllTrainers={getAllTrainers} />} />
      </Routes>
    </>
  )
}

export default App
