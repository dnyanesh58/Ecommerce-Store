import React from 'react'
import { MDBFooter } from 'mdb-react-ui-kit';
function Footer() {
  return (
    <div>
    <MDBFooter className='text-center text-lg-left' style={{ backgroundColor: '#808080' }}>
      <div className='text-center p-3 text-white' style={{ backgroundColor: 'rgba(0, 0, 0, 0.2)' }}>
        &copy; {new Date().getFullYear()} Copyright:{' '}
        <a className='text-white' href='http://localhost:3000/'>
        PlumbingStore.com
        </a>
        </div>
    </MDBFooter>
    </div>
  )
}

export default Footer