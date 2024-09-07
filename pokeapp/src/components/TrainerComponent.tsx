import React from 'react'
import { Link } from 'react-router-dom'
import  { Trainer } from '../types/trainer-type';

const TrainerComponent = (trainer: Trainer) => {
    return (
      <Link to={`/trainers/${trainer.id}`} className="trainer__item">
              <div className="trainer__header">
                  <div className="trainer__details">
                      <p className="trainer_name">{trainer.name.substring(0, 15)} </p>
                  </div>
              </div>
              <div className="trainer__body">
                  <p>{trainer.status === 'Active' ? <i className='bi bi-check-circle'></i> : 
                      <i className='bi bi-x-circle'></i>} {trainer.status}</p>
              </div>
          </Link>
    )
  }
export default TrainerComponent