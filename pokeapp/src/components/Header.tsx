import React from 'react'

// Define the props interface
interface HeaderProps {
    toggleModal: (open: boolean) => void; // Function type that takes a boolean and returns void
    nbOfTrainers: number; // Number type for the number of trainers
  }

const Header: React.FC<HeaderProps> = ({toggleModal, nbOfTrainers}) => {
  return (
    <header className='header'>
        <div className='container'>
            <h3>Trainer List({nbOfTrainers})</h3>
            <button onClick={() => toggleModal(true)} className='btn'>
                <i className='bi bi-plus-quare'></i>Add New Trainer
            </button>
        </div>   
    </header>
  )
}

export default Header