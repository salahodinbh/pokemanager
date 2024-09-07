import React from 'react'
import TrainerComponent from './TrainerComponent'
import { Trainer } from '../types/trainer-type';
import { TrainerListProps } from '../types/trainer-type';

const TrainerList: React.FC<TrainerListProps> = ({data, currentPage, getAllTrainers}) => {
  return (
    <main className='main'>
        {data?.content?.length === 0 && <div className='no-trainer'>No trainer found</div>}

        <ul className='trainer__list'>        
            {data?.content?.length > 0 && data.content.map((trainer: Trainer) => (
                <TrainerComponent key={trainer.id} {...trainer} />
            ))}
        </ul>

        {data?.content?.length > 0 && data?.totalPages > 1 && (
            <div className='pagination'>
                <a onClick={() => getAllTrainers(currentPage - 1)} className={0 === currentPage ? 'disabled':''}>&laquo;</a>
                {data && [...Array(data.totalPages).keys()].map((page, index) =>
                    <a onClick={() => getAllTrainers(page)} className={page === currentPage ? 'active':''} key={page}>{page + 1}</a>
                )}
                <a onClick={() => getAllTrainers(currentPage + 1)} className={data.totalPages === currentPage + 1 ? 'disabled':''}>&raquo;</a>
            </div>
        )}
    </main>
  )
}

export default TrainerList;