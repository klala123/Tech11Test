package com.example.tech11Test.business.abstractModule;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Predicate;


public abstract  class AbstractStorage<T extends  AbstractModule> {
     protected final Map<Long, T> storage = new HashMap<>();
     protected final AtomicLong key = new AtomicLong( 1L );
     private void createOneModule(final T module ) {
          create( module );
     }

     public void create( final T module )
     {
          final long newKey = this.key.getAndIncrement( );
          this.storage.put( newKey, module );
          module.setId( newKey );
     }

     public Optional<T> readById(final long key )
     {
          if ( this.storage.containsKey( key ) )
          {
               return Optional.of( this.storage.get( key ) );
          }
          else
          {
               return Optional.empty( );
          }
     }

     public abstract Collection<T> findByFilters( final Predicate<T> predicate );

     public void update( final T module )
     {
          this.storage.put( module.getId( ), module );
     }

     public void delete( final long moduleId )
     {
          this.storage.remove( moduleId);
     }

     public boolean containsId( final long id )
     {
          return this.storage.containsKey( id );
     }

     public void deleteById( final long id )
     {
          this.storage.remove( id );
     }

     public Collection<T> findAll( )
     {
          return this.storage.values();
     }

     public Predicate<T> predicateAll (){
          return l -> true ;
     }
}
