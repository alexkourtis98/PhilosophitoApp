# Philosophito App - Architecture Documentation

## Overview
This document describes the modernized architecture of the Philosophito Android app, following Clean Architecture principles with MVVM pattern.

## Architecture Layers

### 1. Presentation Layer (UI)
- **Fragments**: UI screens
- **ViewModels**: Manage UI state and business logic
- **Adapters**: RecyclerView adapters for lists

### 2. Domain Layer (Business Logic)
- **Use Cases**: Business logic operations
- **Domain Models**: Business entities

### 3. Data Layer
- **Repositories**: Abstract data access
- **Data Sources**: Concrete data implementations
  - Local: Room database, SharedPreferences
  - Remote: (Future: API calls)
- **Data Models**: Database entities, DTOs

## Folder Structure

```
app/src/main/java/kourtis/quadrum/philosophito/
├── core/                              # Shared infrastructure
│   ├── data/
│   │   ├── local/
│   │   │   ├── PhilosophitoDatabase   # Room database
│   │   │   ├── dao/                   # Data Access Objects
│   │   │   └── entity/                # Room entities
│   │   ├── repository/
│   │   │   └── BaseRepository         # Base repository interface
│   │   └── preference/
│   │       └── PreferenceManager      # SharedPreferences wrapper
│   ├── ui/
│   │   ├── BaseFragment               # Base fragment with common functionality
│   │   ├── BaseActivity               # Base activity
│   │   └── BaseViewHolder             # Base ViewHolder for RecyclerView
│   ├── navigation/
│   │   └── NavigationManager          # Centralized navigation
│   └── util/
│       ├── Constants                  # App constants
│       └── Extensions                 # Kotlin extensions (future)
│
├── feature/                           # Feature modules (by user journey)
│   ├── theory/                        # Moral Theories feature
│   │   ├── data/
│   │   │   ├── model/
│   │   │   │   └── Theory             # Theory domain model
│   │   │   ├── source/
│   │   │   │   └── TheoryLocalDataSource
│   │   │   └── repository/
│   │   │       └── TheoryRepository
│   │   ├── domain/
│   │   │   └── usecase/
│   │   │       ├── GetAllTheoriesUseCase
│   │   │       └── GetTheoryByIdUseCase
│   │   └── presentation/
│   │       ├── list/
│   │       │   ├── TheoriesFragment
│   │       │   ├── TheoriesViewModel
│   │       │   └── TheoriesAdapter
│   │       └── detail/
│   │           ├── TheoryDetailActivity
│   │           └── TheoryDetailViewModel
│   │
│   ├── issue/                         # Moral Issues feature
│   │   └── (similar structure to theory/)
│   │
│   ├── quiz/                          # Quiz feature
│   │   ├── data/
│   │   │   ├── model/
│   │   │   │   ├── Quiz
│   │   │   │   └── QuizQuestion
│   │   │   ├── source/
│   │   │   │   └── QuizLocalDataSource
│   │   │   └── repository/
│   │   │       └── QuizRepository
│   │   ├── domain/
│   │   │   └── usecase/
│   │   │       ├── GetQuizByIdUseCase
│   │   │       ├── SubmitQuizAnswersUseCase
│   │   │       └── CalculateScoreUseCase
│   │   └── presentation/
│   │       ├── menu/
│   │       │   ├── QuizMenuFragment
│   │       │   ├── QuizMenuViewModel
│   │       │   └── QuizListAdapter
│   │       ├── question/
│   │       │   ├── QuizFragment
│   │       │   └── QuizViewModel
│   │       └── result/
│   │           ├── QuizResultsFragment
│   │           └── QuizResultsViewModel
│   │
│   ├── dictionary/                    # Dictionary feature
│   │   └── (similar structure)
│   │
│   ├── extras/                        # Food for Thought feature
│   │   └── (similar structure)
│   │
│   ├── favorites/                     # Favorites feature
│   │   └── (similar structure)
│   │
│   └── settings/                      # Settings feature
│       └── presentation/
│           └── SettingsFragment
│
└── MainActivity.java                  # Root navigation host
```

## Design Patterns Used

### 1. MVVM (Model-View-ViewModel)
- **View**: Fragments/Activities observe ViewModel
- **ViewModel**: Holds UI state, survives configuration changes
- **Model**: Repositories provide data to ViewModel

### 2. Repository Pattern
- Abstracts data sources from business logic
- Single source of truth for data
- Allows easy switching between local/remote data sources

### 3. Use Case Pattern (Optional)
- Encapsulates single business operation
- Reusable across multiple ViewModels
- Testable in isolation

### 4. ViewHolder Pattern
- Proper RecyclerView implementation
- Improves list performance
- Reduces findViewById calls

## Data Flow

```
User Action → Fragment → ViewModel → Use Case → Repository → Data Source
                ↑            ↓
                └─ LiveData ─┘
```

## Key Improvements Over Old Architecture

### Before (Problems):
1. **Static State Singleton**: All data in static variables
2. **No Lifecycle Awareness**: Memory leaks from static references
3. **No Separation of Concerns**: UI directly accessing data
4. **Technical Layering**: Code organized by type (adapters/, data/)
5. **ListView**: Deprecated, no ViewHolder pattern
6. **No Testing**: Impossible to unit test

### After (Solutions):
1. **Room Database**: Proper persistence, type-safe queries
2. **ViewModel + LiveData**: Lifecycle-aware, survives rotation
3. **Repository Pattern**: Clear separation of concerns
4. **Feature Modules**: Code organized by user journey
5. **RecyclerView**: Modern, efficient, proper ViewHolder
6. **Testable**: Each layer can be unit tested independently

## Migration Strategy

### Phase 1: Core Infrastructure
- Create Room database
- Create base classes (BaseFragment, BaseViewModel)
- Create repository interfaces

### Phase 2: Feature Migration (One at a time)
- Start with simplest feature (Dictionary)
- Create feature folder structure
- Implement Repository → ViewModel → Fragment
- Test thoroughly
- Repeat for each feature

### Phase 3: Cleanup
- Remove old State.java singleton
- Remove deprecated ListView code
- Fix all @SuppressLint warnings

## Database Schema

### Tables:
- `theories` - Moral theories content
- `issues` - Moral issues content
- `dictionary_items` - Dictionary terms
- `quizzes` - Quiz metadata
- `quiz_questions` - Quiz questions
- `extras` - Food for thought items
- `favorites` - User favorites

## Benefits for Portfolio

This architecture demonstrates:
- ✅ Modern Android development practices
- ✅ Clean Architecture principles
- ✅ SOLID principles
- ✅ Testable code
- ✅ Scalable codebase
- ✅ Industry-standard patterns
- ✅ Code quality and maintainability
