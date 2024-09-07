// Define an interface for paginated response if applicable
export interface TrainerPaginatedResponse<Trainer> {
    content: Trainer[];
    totalPages: number;
    totalElements: number;
}

// Define the props interface
export interface TrainerListProps {
    data: TrainerPaginatedResponse<Trainer>; // Use PaginatedResponse with Trainer type
    currentPage: number; // Current page number
    getAllTrainers: (page: number) => void; // Function type to get trainers by page
}

export interface Trainer {
    id?: number; // Assuming id might be optional when creating a new trainer
    name: string;
    age: number;
    status: string;
    // Add other fields as needed
}