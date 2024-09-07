import axios from 'axios';
import  { Trainer } from '../types/trainer-type';

const API_URL = 'http://localhost:8080/trainers';

export async function saveTrainer(trainer: Trainer) {
    return await axios.post(API_URL, trainer);
}

export async function getTrainers(page = 0, size = 10) {
    return await axios.get(`${API_URL}?page=${page}&size=${size}`);
}

export async function getTrainer(id: number) {
    return await axios.get(`${API_URL}/${id}`);	
}

export async function updateTrainer(trainer: Trainer) {
    return await axios.put(API_URL, trainer);
}

export async function deleteTrainer(id: number) {
    return await axios.delete(`${API_URL}/${id}`);
}